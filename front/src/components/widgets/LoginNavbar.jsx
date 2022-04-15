import React from "react";
import { Link } from "react-router-dom";

function LoginNavbar() {
  return (
    <nav className="NavbarItems">
      <Link to="/login" className="nav-links">
        Login
      </Link>
      <Link to="/register" className="nav-links">
        Register
      </Link>
    </nav>
  );
}

export default LoginNavbar;
