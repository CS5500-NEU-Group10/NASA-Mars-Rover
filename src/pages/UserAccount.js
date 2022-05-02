import React from "react";
import "../style/Login.css";
// import PropTypes from "prop-types";
import UserNamePasswordEdit from "../components/UserNamePasswordEdit";

function UserAccount() {
  return (
    <div className="web-page">
      <div className="account-section" data-testid="login-test">
        <h1>Please Log In</h1>
        <UserNamePasswordEdit status="login" />
      </div>
    </div>
  );
}

export default UserAccount;
