import axios from 'axios';
import router from "@/router";

const state ={
    context : "http://localhost:5000",
   pages:[],
    list:[],
    pager:{},
    pageNumber:'0',
    searchWord : 'null',
    item:{}


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
    async testClick({commit},payload){
        commit("TRANSFER", payload.pageNumber)
       axios.get(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)
           .then(({data})=>{
               commit("TRANSFER",data)
           })
           .catch()

    },
    async movieclick({commit},payload){
        axios.get(`${state.context}/${payload.cate}/${payload.searchWord}`)
            .then(({data})=>{
                commit("DETAIL",data)
                    router.push("/detail");
            })
            .catch()
    }
 }

 const mutations ={
     DETAIL(state,data){
         state.item=data
     },

    SEARCHWORD(state, data){
        // alert(`뮤테이션:: ${data}`)
         state.searchWord = data
     },
     TRANSFER(state, data){
        state.pager=data.pager
         state.list=data.list
     },

};
const getters ={

}



export default {
    name:"search",
    namespaced: true,
    state,
    actions,
    mutations,
    getters

}