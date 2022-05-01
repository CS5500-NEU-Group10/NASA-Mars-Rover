// import { mount } from "@cypress/react";
// import Filter from "../../src/pages/Filter";
// import React from "react";
//test to check if users are taken to homepage upon clicking the rotating mars sphere
//and if rovers can be clicked and cameras selected
describe("renders landing page and interaction with page", () => {
  beforeEach(() => {
    cy.visit("http://localhost:3002/");
  });

  it("allows search after user selects rover options, camera options, and sol day input", () => {
    cy.visit("http://localhost:3002/Home");
    cy.get(".O-button").click();
    cy.get(".S-button").click();
    cy.get("#flexCheckDisabled").check();
    cy.get("#navcam-id").check();
    cy.get("#pancam-id").check();
    cy.get(".form-control").clear();
    cy.get(".form-control").type("60");
    cy.get("#submitBtn").click();
  });
});
