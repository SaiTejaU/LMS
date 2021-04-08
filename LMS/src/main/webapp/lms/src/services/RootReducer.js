import {combineReducers} from 'redux';
import LibrarianReducer from './Librarian/LibrarianReducer';

const RootReducer=combineReducers({
    bookData:LibrarianReducer
});
export default RootReducer;