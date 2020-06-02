<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
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
                <tr v-for="item of movie" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td>{{ item.movieName }}</td>
                    <td>{{ item.rankDate }}</td>

                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
           <div >
               <span v-if="existPrev" class="pagenation" >PREV</span>
               <span v-for="n of arr" :key="n" class="pagenation">{{n}}</span>
               <span v-if="existNext " class="pagenation" >NEXT</span>
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
    export default {
        data () {
            return {
                page: 1,
                arr:[6,7,8,9,10],
                existPrev:false,
                existNext:true

            }
        },
        created() {
            alert('무비에서 크리티드 실행됌')
        },
        computed: {
            ...mapState({
                count: state => state.crawling.count,
               movie: state => state.crawling.movie
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