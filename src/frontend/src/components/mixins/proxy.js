import axios from "axios";


export  const  proxy = {
    methods: {
        tester(d){
          alert(d)

        },
        movieclick(seq){
            alert(seq)
        },

        paging(url) {
            const movie = []
            const pages = []
            let temp = {}
            axios.get(url)
                .then(({data}) => {
                    data.list.forEach(elem => {
                        movie.push(elem)
                    })
                    let pager = data.pager

                    let i = pager.pageStart + 1

                    for (; i <= pager.pageEnd + 1; i++) {
                        pages.push(i)
                    }
                    temp.rowCount = pager.rowCount
                    temp.existPrev = pager.existPrev
                    temp.existNext = pager.existNext
                    temp.nextBlock=pager.nextBlock
                    temp.prevBlock=pager.prevBlock
                })
                .catch(err => {
                    alert(`영화 통신 실패 ${err}`)
                })
            return {movie, pages, temp}
        }
    }
}