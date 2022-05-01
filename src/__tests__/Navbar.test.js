import { render, screen } from "@testing-library/react";
import Navbar from "../components/Navbar";
import { BrowserRouter } from "react-router-dom";
import React from "react";

test("renders navbar correctly", () => {
  render(
    <BrowserRouter>
      <Navbar />
    </BrowserRouter>
  );
  const loginElement = screen.getByTestId("navbar-test");
  expect(loginElement).toBeInTheDocument();
});
