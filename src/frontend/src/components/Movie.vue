<template>
    <div>
        <h3>총게시글수 : {{pager.rowCount}}</h3>
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
                    <td>{{ item.movieName }}</td>
                    <td>{{ item.rankDate }}</td>

                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
           <div >
               <span v-if='pager.existPrev' class="pagenation" >PREV</span>
               <span v-for="n of pages" :key="n" class="pagenation">{{n}}</span>
               <span v-if='pager.existNext' class="pagenation" >NEXT</span>
           <!--
               <span style="width: 50px;height: 50px; border: 1px solid palevioletred;margin-right: 5px" >이전</span>
            <span style="width: 50px;height: 50px; border: 1px solid palevioletred;margin-right: 5px" >1</span>
            <span style="width: 50px;height: 50px; border: 1px solid palevioletred;margin-right: 5px" >2</span>
            <span style="width: 50px;height: 50px; border: 1px solid palevioletred;margin-right: 5px" >3</span>
            <span style="width: 50px;height: 50px; border: 1px solid palevioletred;margin-right: 5px" >4</span>
            <span style="width: 50px;height: 50px; border: 1px solid palevioletred;margin-right: 5px" >5</span>
               <span style="width: 50px;height: 50px; border: 1px solid palevioletred;margin-right: 5px" >다음</span>
   -->
           </div>
          <!--  <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>


</template>

<script>
    import { mapState } from "vuex";
    import axios from "axios";
    export default {
        data () {
            return {
                pageNumber: 0,
                pages:[],

                list:[],
                pager: {},
                totalCount: '',

            }
        },
        created() {
          //  this.$store.dispatch("search/find", this.searchWord);
            axios.get(`${this.$store.state.search.context}/movie/${this.$store.state.search.searchWord}/${this.$store.state.search.pageNumber}`)
                    .then(res=>{
                       res.data.list.forEach(elem =>{this.list.push(elem)})
                        this.pager = res.data.pager
                        let i =this.pager.pageStart+ 1
                        let arr =[]
                        console.log(`페이지 끝 :${this.pager.pageEnd}`)
                        for(;i<=this.pager.pageEnd +1;i++){
                            arr.push(i)
                        }
                        this.pages = arr
                    })
                    .catch(err=>{
                        alert(`영화 통신실패 ${err}`)

                    })
        },
        computed: {
            ...mapState({
                count: state => state.crawling.count,
               movie: state => state.crawling.movie,
                bugsmusic:state=>state.crawling.bugsmusic
            })
        }
    };
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
        border: 1px solid palevioletred;
        margin-right: 5px
    }
</style>