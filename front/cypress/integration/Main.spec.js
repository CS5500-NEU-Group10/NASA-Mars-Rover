//test to check if users are taken to homepage upon clicking the rotating mars sphere
//and if rovers can be clicked and cameras selected
describe("renders landing page and interaction with page", () => {
  it("visits page", () => {
    cy.visit("http://localhost:3002/");
  });

  it("allows search after user selects rover options, camera options, and sol day input", () => {
    cy.visit("http://localhost:3002/Home");

    cy.get(":nth-child(1) > .btn").click({ force: true });
    cy.get(":nth-child(2) > .btn").click({ force: true });
    cy.get("#flexCheckDisabled").check({ force: true });
    cy.get(
      ":nth-child(2) > :nth-child(1) > .form-check > .form-check-input"
    ).check({ force: true });
    cy.get('[data-testid="sol-input"]').clear();
    cy.get('[data-testid="sol-input"]').type("50");
    cy.get('[data-testid="submit-test"]').click();
  });
});
