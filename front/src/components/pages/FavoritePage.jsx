import React from "react";
import FunctionNavbar from "../widgets/FunctionNavbar";
import FavoriteSection from "../sections/FavoriteSection";
export const UserContext = React.createContext("");

function FavoritePage() {
  let user = localStorage.getItem("user");

  return (
    <>
      <FunctionNavbar />
      <div className="web-page">
        <UserContext.Provider value={user}>
          <div className="photo-section">
            <FavoriteSection />
          </div>
        </UserContext.Provider>
      </div>
    </>
  );
}

export default FavoritePage;
