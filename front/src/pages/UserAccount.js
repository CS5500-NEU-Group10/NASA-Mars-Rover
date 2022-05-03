import React from "react";
import "../style/Login.css";
import PropTypes from "prop-types";
import UserNamePasswordEdit from "../components/UserNamePasswordEdit";

function UserAccount({ login, setLogin }) {
  return (
    <div className="web-page">
      <div className="account-section" data-testid="login-test">
        <h1>Please Log In</h1>
        <UserNamePasswordEdit
          status="login"
          login={login}
          setLogin={setLogin}
        />
      </div>
    </div>
  );
}
UserAccount.propTypes = {
  login: PropTypes.any,
  setLogin: PropTypes.func,
};
export default UserAccount;
