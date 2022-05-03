//Test to check if images can be favorited

describe("saves favorite images", () => {
  it("visits page", () => {
    cy.visit("http://localhost:3002/");
  });

  it("allows images to be liked after search", () => {
    cy.visit("http://localhost:3002/Home");
    /* ==== Generated with Cypress Studio ==== */
    cy.get(":nth-child(1) > .btn").click({ force: true });
    cy.get(":nth-child(2) > .btn").click({ force: true });
    cy.get(":nth-child(1) > :nth-child(1) > .form-check").click({
      force: true,
    });
    cy.get("#flexCheckDisabled").check({ force: true });
    cy.get("#navcam-id").check({ force: true });
    cy.get('[data-testid="sol-input"]').clear();
    cy.get('[data-testid="sol-input"]').type("55");
    cy.get('[data-testid="submit-test"]').click();

    cy.get(
      ':nth-child(1) > :nth-child(1) > .card-body > .cardlink > .hearbtn > .heart > g > [d="M12.001 4.529c2.349-2.109 5.979-2.039 8.242.228 2.262 2.268 2.34 5.88.236 8.236l-8.48 8.492-8.478-8.492c-2.104-2.356-2.025-5.974.236-8.236 2.265-2.264 5.888-2.34 8.244-.228zm6.826 1.641c-1.5-1.502-3.92-1.563-5.49-.153l-1.335 1.198-1.336-1.197c-1.575-1.412-3.99-1.35-5.494.154-1.49 1.49-1.565 3.875-.192 5.451L12 18.654l7.02-7.03c1.374-1.577 1.299-3.959-.193-5.454z"]'
    ).click({ force: true });

    /* ==== End Cypress Studio ==== */
  });
});
