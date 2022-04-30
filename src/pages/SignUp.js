import React from "react";
import "../style/Login.css";
import PropTypes from "prop-types";
import UserNamePasswordEdit from "../components/UserNamePasswordEdit";

function SignUp() {
  return (
    <div className="web-page">
      <div className="account-section">
        <h1>Please Sign Up</h1>
        <UserNamePasswordEdit status="register" />
      </div>
    </div>
  );
}

SignUp.propTypes = {
  inputUserName: PropTypes.any.isRequired,
  setInputUserName: PropTypes.any,
  inputPassword: PropTypes.any,
  setInputPassword: PropTypes.any,
  status: PropTypes.any,
  setStatus: PropTypes.any,
};
export default SignUp;
