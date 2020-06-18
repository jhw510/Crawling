<template>
    <div>
        <h3>총게시글수 : {{pager.rowCount}}</h3>
        <span style="float:right; margin-right: auto ">
            <input id="searchWord" type="text" style="border: 3px solid #4485f3">
            <button @click="tester"> 검색</button></span>

        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">영화 제목</th>
                    <th class="text-left">영화 랭킹 날짜</th>


                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td><a id='sw' @click="movieclick(item.seq)" href="#">{{ item.movieName }}</a></td>
                    <td>{{ item.rankDate }}</td>

                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
           <div >
               <span @click="testClick(pager.prevBlock)" v-if='pager.existPrev' class="pagenation" >PREV</span>
               <span @click="testClick(n)" v-for="n of pages" :key="n" class="pagenation">{{n}}</span>
               <span @click="testClick(pager.nextBlock)" v-if='pager.existNext' class="pagenation" >NEXT</span>

           </div>
          <!--  <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>


</template>

<script>
    import { mapState } from "vuex";
    import {proxy} from "./mixins/proxy"
    export default {
       mixins:[proxy],
        created() {
            console.log('페이징 가기전 :')
            let json = proxy.methods.paging(`${this.$store.state.search.context}/movie/null/0`)
            this.$store.state.search.list = json.movie
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp
            console.log('페이징 다녀온 다음  :' +json.temp.pageSize)
        },

        computed: {
            ...mapState({
                list: state => state.search.list,
                pages: state => state.search.pages,
                pager:state=>state.search.pager
            })
        },
        methods:{
            testClick(d){
                proxy.methods.tester(d)
                this.$store.dispatch("search/testClick",
                {cate:'movie',searchWord:null,pageNumber:d-1})
            },
            tester(){
               // let s= document.getElementById('searchWord')
               //  let v=s.value
               //  proxy.methods.tester()          원래는 이런상태

                  let searchWord=document.getElementById('searchWord').value
                if(searchWord ==='') searchWord ='null'
                     this.$store.dispatch("search/testClick",
                    {cate:'movie',searchWord:document.getElementById('searchWord').value,pageNumber:0})

                    },
            movieclick(searchWord){
                //let seq= document.getElementById('seq').value
                this.$store.dispatch("search/movieclick",
                    {cate:'movie',searchWord:searchWord})
             //   proxy.methods.movieclick(seq)
            }
             }
        }


</script>
<style scoped>
   .text-center{
       margin: 0 auto;
       width: 500px;
       height: 100px
   }
    .pagenation{
        width: 50px;
        height: 50px;
        border: 1px solid #db7093;
        margin-right: 5px
    }
</style>