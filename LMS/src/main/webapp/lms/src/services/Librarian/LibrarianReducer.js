
const reducer=(state=[],action)=>{
    switch(action.type){
        case 'FETCH_BOOKS':
            return action.payload;
        default:
            return state;
    }
};
export default reducer;