import React, { useEffect, useState } from "react";
import PropTypes from "prop-types";
import "../style/Render.css";
import { RiHeartLine, RiHeartFill } from "react-icons/ri";
// import { useLocation } from "react-router-dom";

function Fave({ faveIdToImage, setFaveIdToImage, addFave, removeFave }) {
  let user = localStorage.getItem("user");

  // let faveIdToImage = location.state["faveIdToImage"];
  let imagesArr = Array.from(faveIdToImage.values());

  // Recover Map object from string
  // Corresponding to the mapToString function below
  function stringToMap(mapString) {
    let mapObj = JSON.parse(mapString);
    const tempMap = new Map();
    for (let key in mapObj) {
      let value = mapObj[key];
      tempMap.set(Number(key), JSON.parse(value));
    }
    return tempMap;
  }

  async function fetchFaveData() {
    const result = await fetch(`/api/get_favorite/${user}`, {
      method: "GET",
    });
    let itemsObj = await result.json();
    let faveMap = stringToMap(itemsObj.data);

    return faveMap;
  }

  useEffect(() => {
    fetchFaveData().then((faveItems) => {
      setFaveIdToImage(faveItems);
    });
  }, []);

  /**
   * function that renders heart icon
   * @returns heart icon in conditional rendering
   */
  function renderHeart(_pic) {
    // let history = useHistory();
    // console.log("History.pop", history.pop);
    return (
      <a
        className="hearbtn"
        onClick={() => {
          // history.push(_pic.id);
          faveIdToImage.get(_pic.id) ? removeFave(_pic) : addFave(_pic);
        }}
      >
        {faveIdToImage.get(_pic.id) ? (
          <RiHeartFill className="heart" size={30} style={{ color: "red" }} />
        ) : (
          <RiHeartLine className="heart" size={30} style={{ color: "red" }} />
        )}
      </a>
    );
  }

  return (
    <div className="Fave">
      <div className="card-group " id="cardGroupFave">
        {imagesArr.map((roverpic) => (
          <div className="card container" id="cardimage" key={roverpic.id}>
            <div className="card-body">
              <h5 className="card-title"> Rover: {roverpic.rover.name}</h5>
              <img className="imgs" src={roverpic.img_src} alt="" />
              <p className="card-text">
                Sol: {roverpic.sol}
                <br />
                Earth Date: {roverpic.earth_date}
                <br />
                Landing Date:{roverpic.rover.landing_date}
                <br />
                Status: {roverpic.rover.status}
              </p>
              <div className="cardlink">{renderHeart(roverpic)}</div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

Fave.propTypes = {
  faveIdToImage: PropTypes.any.isRequired,
  addFave: PropTypes.any.isRequired,
  removeFave: PropTypes.any.isRequired,
  setFaveIdToImage: PropTypes.any,
};
export default Fave;
