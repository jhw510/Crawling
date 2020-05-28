<template>
  <div>
    <div class="imgcontainer">
      <img src="https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png" alt="Avatar" class="avatar">
    </div>
    <div>
      <button @click="search" type="button" class="btn" >
        <input type="text"  @keyup.enter="searchMusic"  v-model="music" placeholder="Enter searchMusic " required>

        검색</button>
    </div>

    <h1 >벅스   크롤링</h1>


  </div>
</template>

<script>
  export default {
    name: 'HelloWorld',

    data: () => ({}),
    methods: {
      search() {
        alert("검색어버튼누름")
      }
    }
  }
</script>

<style scoped>
  img.avatar {
    width: 40%;
    border-radius: 50%;
  }
</style>