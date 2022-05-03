import React, { useState } from "react";
import "../style/Navbar.css";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";

const Navbar = ({ handleSubmit, login, setLogin }) => {
  const [isNavCollapsed, setIsNavCollapsed] = useState(true);
  const handleNavCollapse = () => setIsNavCollapsed(!isNavCollapsed);

  function signUpRender() {
    return (
      <div className="btn-login nav-link">
        <Link to="/SignUp" style={{ textDecoration: "none" }}>
          <button className="main-btn"> Sign Up </button>
        </Link>
      </div>
    );
  }
  return (
    <div className="Navbar" data-testid="navbar-test">
      <nav className="navbar navbar-expand-lg navbar-light">
        <div className="container">
          <Link to="/" style={{ textDecoration: "none" }}>
            <p className="navbar-brand" id="navbar-brand">
              Mars Roverland
            </p>
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded={!isNavCollapsed ? true : false}
            aria-label="Toggle navigation"
            onClick={handleNavCollapse}
            style={{ color: "white" }}
          >
            <span
              className="navbar-toggler-icon"
              style={{ backgroundColor: "#800080", color: "white" }}
            ></span>
          </button>
          {/* <div
            className="collapse navbar-collapse "
            style={{ color: "white" }}
            id="navbarNav"
          > */}
          <div
            className={`${isNavCollapsed ? "collapse" : ""} navbar-collapse`}
            id="navbarNav"
          >
            <ul className="navbar-nav">
              <li className="nav-item">
                <Link to="/Home" style={{ textDecoration: "none" }}>
                  <p className="nav-link" id="home" onClick={handleSubmit}>
                    Home
                  </p>
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/MyFavorites" style={{ textDecoration: "none" }}>
                  <p className="nav-link" id="myfave">
                    My Favorites
                  </p>
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/Curiosity" style={{ textDecoration: "none" }}>
                  <p className="nav-link" id="myfave">
                    Curiosity
                  </p>
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/Opportunity" style={{ textDecoration: "none" }}>
                  <p className="nav-link" id="myfave">
                    Opportunity
                  </p>
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/Spirit" style={{ textDecoration: "none" }}>
                  <p className="nav-link" id="myfave">
                    Spirit
                  </p>
                </Link>
              </li>
              <li className="nav-item">{login ? "" : signUpRender()}</li>
              <li className="nav-item">
                <div className="btn-login nav-link">
                  <Link to="/Login" style={{ textDecoration: "none" }}>
                    <button className="main-btn" id="login-btn">
                      {login ? "Logout" : "Login"}
                      {console.log("Login", login)}
                    </button>
                  </Link>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
};

Navbar.propTypes = {
  handleSubmit: PropTypes.func,
  faveIdToImage: PropTypes.any,
  setFaveIdToImage: PropTypes.any,
  login: PropTypes.any,
  setLogin: PropTypes.any,
};
export default Navbar;
