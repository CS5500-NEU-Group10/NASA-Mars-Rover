import React, { useState, useEffect } from "react";
import "./App.css";
import Navbar from "./components/Navbar";
import { BrowserRouter, Routes, Route } from "react-router-dom";
// import Home from "./pages/Home";
import UserAccount from "./pages/UserAccount";
import Opportunity from "./components/Opportunity";
import Main from "./pages/Main";
import Spirit from "./components/Spirit";
import Curiosity from "./components/Curiosity";
import Landing from "./pages/Landing";
import Fave from "./pages/Fave";
import SignUp from "./pages/SignUp";

function App() {
  let user = localStorage.getItem("user");
  let [faveIdToImage, setFaveIdToImage] = useState(new Map());

  /**
   *  Convert Map object into string
   Corresponding to the stringToMap function below
   * @param {Map} map object
   * @returns JSON object
   */
  function mapToString(map) {
    //{id:obj,}
    let mapObj = {};
    map.forEach((v, k) => {
      mapObj[k] = JSON.stringify(v);
    });
    let mapString = JSON.stringify(mapObj);
    return mapString;
  }
  /**
   * updates favorite to backend
   * @param {Number} user_id
   * @param {Map} favoriteMap
   */
  function updateBackend(user_id, favoriteMap) {
    // Update to the backend
    const tempMapString = mapToString(favoriteMap);
    fetch(`/api/save_favorite?user_id=${user_id}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: tempMapString,
    });
  }
  /**
   * adds favorite images to faveIdToImage map, sets map and updates backend
   * @param {Object} obj
   */
  const addFave = (obj) => {
    const tempMap = new Map(faveIdToImage);
    tempMap.set(obj.id, Object.assign({}, obj));
    setFaveIdToImage(tempMap);
    updateBackend(user, tempMap);
  };

  /**
   * removes favorite from faveIdToImage map and updates backend
   * @param {object} obj
   */
  const removeFave = (obj) => {
    const tempMap = new Map(faveIdToImage);
    tempMap.delete(obj.id);
    setFaveIdToImage(tempMap);
    updateBackend(user, tempMap);
  };

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

  return (
    <div className="App" id="container">
      <BrowserRouter>
        <Navbar
          faveIdToImage={faveIdToImage}
          setFaveIdToImage={setFaveIdToImage}
        />
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route
            path="/Home"
            element={
              <Main
                faveIdToImage={faveIdToImage}
                setFaveIdToImage={setFaveIdToImage}
                addFave={addFave}
                removeFave={removeFave}
              />
            }
          />
          <Route
            path="/MyFavorites"
            element={
              <Fave
                faveIdToImage={faveIdToImage}
                setFaveIdToImage={setFaveIdToImage}
                addFave={addFave}
                removeFave={removeFave}
              />
            }
          />
          <Route path="/Opportunity" element={<Opportunity />} />
          <Route path="/Curiosity" element={<Curiosity />} />
          <Route path="/Spirit" element={<Spirit />} />
          <Route path="/Login" element={<UserAccount />} />
          <Route path="/SignUp" element={<SignUp />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
