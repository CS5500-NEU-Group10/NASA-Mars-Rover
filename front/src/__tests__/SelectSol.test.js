import SelectSol from "../components/SelectSol";
import { render, fireEvent, screen } from "@testing-library/react";
import React from "react";

it("render sol-input", () => {
  // let mockFaveToImage = new Map()

  // const component = renderer.create(<Main faveIdToImage={mockFaveToImage}/>)
  // const tree = component.toJSON();
  // expect(tree).toMatchSnapshot();

  const { getByTestId } = render(<SelectSol />);
  const sol = screen.getByTestId("sol-input");
  fireEvent.change(sol, { target: { value: "50" } });
  expect(getByTestId("sol-input").value).toBe("50");
});
