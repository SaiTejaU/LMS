import React from 'react'; 
import App from './App'; 
import { create } from 'react-test-renderer' 
describe('My first snapshot test',()=>{
 test('testing app Component', () => {
       let tree = create(<App />) 
       expect(tree.toJSON()).toMatchSnapshot(); 
})
 }) 