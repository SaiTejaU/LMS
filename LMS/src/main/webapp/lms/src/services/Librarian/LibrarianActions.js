import {FETCH_BOOKS} from './LibrarianTypes';
import axios from 'axios';

export const fetchBooks=()=>{
    return dispatch=>{
        axios.get("http://localhost:8083/library/getallbooks")
        .then(response=>{
            dispatch({
                type: FETCH_BOOKS,
                payload: response.data
            });
        });
    };
};