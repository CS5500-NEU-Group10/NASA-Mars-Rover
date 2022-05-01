import { render, screen, fireEvent } from "@testing-library/react";
import UserNamePasswordEdit from "../components/UserNamePasswordEdit";
import { BrowserRouter } from "react-router-dom";
import React from "react";

test("renders navbar correctly", () => {
  render(
    <BrowserRouter>
      <UserNamePasswordEdit status="register" />
    </BrowserRouter>
  );
  const loginElement = screen.getByTestId("user-input-test");
  expect(loginElement.value).toBeFalsy();

  fireEvent.change(loginElement, { target: { value: "123" } });
  expect(loginElement.value).toBe("123");
});
