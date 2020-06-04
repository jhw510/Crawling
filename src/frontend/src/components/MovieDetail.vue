<template>
    <div>
     <h1>검색결과</h1>
        <h1>seq:{{detail.seq }}</h1>
        <h1>movieName:{{detail.movieName}}</h1>
        <h1>rankDate:{{ detail.rankDate}}</h1>

    </div>

</template>

<script>
    import {mapState} from "vuex";


    export default {

        computed:{
           ...mapState({
               detail : state => state.search.item
           })
       }
    }
</script>

<style scoped>

</style>