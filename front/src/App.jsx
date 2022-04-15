import React from "react";
import "./css/List.css";
import "./css/Navbar.css";
import RegistrationPage from "./components/pages/RegistrationPage";
import LoginPage from "./components/pages/LoginPage";
import PhotoPage from "./components/pages/PhotoPage";
import FavoritePage from "./components/pages/FavoritePage";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/register" element={<RegistrationPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/photo" element={<PhotoPage />} />
        <Route path="/favorite" element={<FavoritePage />} />
      </Routes>
    </>
  );
}

export default App;
