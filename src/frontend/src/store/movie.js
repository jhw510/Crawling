import axios from 'axios';
import router from "@/router";

const state ={
    context:"http://localhost:5000/",
    movie:[],

}
const actions={
    async search({commit},searchWord){
        alert("검색어 :" + searchWord);
        axios.get(state.context+`movie/`+searchWord)
            .then(({data})=>{
                commit("SEARCH",data)
                router.push("/movie");
            })
            .catch(() => {
                alert("통신 실패 !");
            });
    }
};
const mutations ={
    SEARCH(){
        alert("뮤테이션 진입")

    }
    /*SEARCH(state, data) {

            state.movie = [];

            data.list.forEach(item => {
                state.movie.push({
                    seq: item.seq,
                    movieName: item.movieName
                });
    })
}*/
};
const getters ={
    movie: state =>state.movie
};
export default {
    name:"movie",
    namespaced:true,
    state,
    actions,
    mutations,
    getters
};