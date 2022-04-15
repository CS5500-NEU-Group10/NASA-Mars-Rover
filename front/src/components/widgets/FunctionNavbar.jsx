import React from "react";
import { Link } from "react-router-dom";

function FunctionNavbar() {
  return (
    <nav className="NavbarItems">
      <Link to="/login" className="nav-links">
        Login
      </Link>
      <Link to="/register" className="nav-links">
        Register
      </Link>
      <Link to="/photo" className="nav-links">
        Photo
      </Link>
      <Link to="/favorite" className="nav-links">
        Favorite
      </Link>
    </nav>
  );
}

export default FunctionNavbar;
