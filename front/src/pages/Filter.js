import React from "react";
import "../style/Filter.css";
import SelectRover from "../components/SelectRover";
import SelectCamera from "../components/SelectCamera";
import PropTypes from "prop-types";

function Filter({
  imgs,
  isCButtonActive,
  isOButtonActive,
  isSButtonActive,
  handleCButton,
  handleOButton,
  handleSButton,
  handleSelectOption,
  handleSubmitData,
}) {
  //functions passed as props to children components
  return (
    <div className="Filter">
      <SelectRover
        isCButtonActive={isCButtonActive}
        isOButtonActive={isOButtonActive}
        isSButtonActive={isSButtonActive}
        handleCButton={handleCButton}
        handleOButton={handleOButton}
        handleSButton={handleSButton}
      />
      <SelectCamera
        imgs={imgs}
        isCButtonActive={isCButtonActive}
        isOButtonActive={isOButtonActive}
        isSButtonActive={isSButtonActive}
        handleSelectOption={handleSelectOption}
        handleSubmitData={handleSubmitData}
        // handleSolDay={handleSolDay}
      />
    </div>
  );
}

Filter.propTypes = {
  imgs: PropTypes.array.isRequired,
  isCButtonActive: PropTypes.bool.isRequired,
  isOButtonActive: PropTypes.bool.isRequired,
  isSButtonActive: PropTypes.bool.isRequired,
  handleCButton: PropTypes.func.isRequired,
  handleOButton: PropTypes.func.isRequired,
  handleSButton: PropTypes.func.isRequired,
  handleSelectOption: PropTypes.func.isRequired,
  handleSubmitData: PropTypes.func.isRequired,
};

export default Filter;
