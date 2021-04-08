import React from "react";
import { create } from "react-test-renderer";

class Button extends React.Component {
  constructor(props) {
    super(props);
    this.state = { text: "" };
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState(() => {
      return { text: "CHECK PENALITY" };
    });
  }

  render() {
    return (
      <button onClick={this.handleClick}>
        {this.state.text || this.props.text}
      </button>
    );
  }
}

describe("Button component", () => {
  test("it shows the expected text when clicked (testing the wrong way!)", () => {
    const component = create(<Button text="CHECK PENALITY" />);
    const instance = component.root;
    const button = instance.findByType("button");
    button.props.onClick();
    expect(button.props.children).toBe("CHECK PENALITY");
  });
});