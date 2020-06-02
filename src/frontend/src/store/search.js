
import router from "@/router";

const state ={
    context : "http://localhost:5000/",
    soccer : [],
    movie:[],
    music:[],
    pager:{},
    pageNumber:0,
    searchWord : 'null',


}
const actions = {

    async find({commit}, searchWord) {
        alert('>>>' + searchWord)
        commit("SEARCHWORD", searchWord)
        switch (searchWord) {
            case '영화':
                router.push("/movie")
                break
            case '음악':
                router.push("/music")
                break
            case '축구':
                router.push("/soccer")
                break
        }
    },
 }

 const mutations ={

    SEARCHWORD(state,data){
         alert(`뮤테이션:: ${data}`)
         state.searchWord = data
     }

};
const getters ={}



export default {
    name:"search",
    namespaced: true,
    state,
    actions,
    mutations,
    getters

}