import React from "react";
import "../style/Login.css";
import PropTypes from "prop-types";
import UserNamePasswordEdit from "../components/UserNamePasswordEdit";

function UserAccount() {
  return (
    <div className="web-page">
      <div className="account-section">
        <h1>Please Log In</h1>
        <UserNamePasswordEdit status="login" />

        <div className="drops">
          <div className="drop drop-1"></div>
          <div className="drop drop-2"></div>
          <div className="drop drop-3"></div>
          <div className="drop drop-4"></div>
          <div className="drop drop-5"></div>
        </div>
      </div>
    </div>
  );
}

UserAccount.propTypes = {
  inputUserName: PropTypes.any.isRequired,
  setInputUserName: PropTypes.any,
  inputPassword: PropTypes.any,
  setInputPassword: PropTypes.any,
  status: PropTypes.any,
  setStatus: PropTypes.any,
};
export default UserAccount;
