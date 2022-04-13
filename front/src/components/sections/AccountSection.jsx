import PropTypes from "prop-types";
import React from "react";
import UserNamePasswordEdit from "../widgets/UserNamePasswordEdit";

function AccountSection(props) {
  return (
    <div className="account-section">
      <h1>Welcome to Our NASA Mars Rover Channel</h1>
      <div className="description">This App Visualizes Photos From Mars!</div>
      <UserNamePasswordEdit status={props.status} />
    </div>
  );
}

AccountSection.propTypes = {
  status: PropTypes.string,
};

export default AccountSection;
