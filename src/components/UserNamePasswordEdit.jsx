import PropTypes from "prop-types";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function UserNamePasswordEdit(props) {
  const [inputUserName, setInputUserName] = useState("");
  const [inputPassword, setInputPassword] = useState("");
  const navigate = useNavigate();

  let button_text = "";
  if (props.status === "register") button_text = "Register";
  else if (props.status === "login") button_text = "Login";

  const register = (accountInfoObj) => {
    // Skip if empty or only containing spaces
    if (
      !accountInfoObj.userName ||
      /^\s*$/.test(
        accountInfoObj.userName || !accountInfoObj.userName.includes("@")
      )
    ) {
      alert("User Name is Not Given!");
      return;
    }
    if (!accountInfoObj.password || /^\s*$/.test(accountInfoObj.password)) {
      alert("Password is Not Given!");
      return;
    }

    let registerUrl =
      "/api/create_user?user_id=" +
      accountInfoObj.userName +
      "&password=" +
      accountInfoObj.password;
    alert("Registration Completed!");
    fetch(registerUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });
  };

  const login = async (accountInfoObj) => {
    // Skip if empty or only containing spaces
    if (!accountInfoObj.userName || /^\s*$/.test(accountInfoObj.userName)) {
      alert("User Name is Not Given!");
      return;
    }
    if (!accountInfoObj.password || /^\s*$/.test(accountInfoObj.password)) {
      alert("Password is Not Given!");
      return;
    }

    let loginUrl =
      "/api/login?user_id=" +
      accountInfoObj.userName +
      "&password=" +
      accountInfoObj.password;
    let result = await fetch(loginUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });
    let isOk = await result.json();
    if (isOk) {
      localStorage.clear();
      localStorage.setItem("user", accountInfoObj.userName);
      alert("Successfully Logged in!");
      navigate("/Home");
    } else {
      alert("Login Failed!");
    }
  };

  const handleUserNameChange = (e) => {
    // Keep the text already entered
    setInputUserName(e.target.value);
  };

  const handlePasswordChange = (e) => {
    // Keep the text already entered
    setInputPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const accountInfoObj = {
      userName: inputUserName,
      password: inputPassword,
    };

    if (props.status === "register") register(accountInfoObj);
    else if (props.status === "login") login(accountInfoObj);

    setInputUserName("");
    setInputPassword("");
  };

  return (
    <form onSubmit={handleSubmit} className="food-form">
      <>
        <input
          placeholder="Enter User Name Here"
          value={inputUserName}
          onChange={handleUserNameChange}
          name="text"
          className="foodname-input"
        />
        <input
          placeholder="Enter Password Here"
          value={inputPassword}
          onChange={handlePasswordChange}
          name="text"
          className="foodname-input"
        />
      </>
      <br />
      <button onClick={handleSubmit} className="login-button">
        {button_text}
      </button>
    </form>
  );
}

UserNamePasswordEdit.propTypes = {
  status: PropTypes.string,
};

export default UserNamePasswordEdit;
