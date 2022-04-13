import React from "react";
import FunctionNavbar from "../widgets/FunctionNavbar";
import PhotoSection from "../sections/PhotoSection";
import FilterSection from "../sections/FilterSection";
export const UserContext = React.createContext("");

function PhotoPage() {
  let user = localStorage.getItem("user");

  return (
    <>
      <FunctionNavbar />
      <div className="web-page">
        <UserContext.Provider value={user}>
          <div className="photo-section">
            <PhotoSection />
          </div>
          <div className="photo-section">
            <FilterSection />
          </div>
        </UserContext.Provider>
      </div>
    </>
  );
}

export default PhotoPage;
