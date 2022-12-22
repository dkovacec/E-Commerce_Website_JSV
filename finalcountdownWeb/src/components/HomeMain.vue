<script>
export default {
  mounted: function () {
    this.created()
  },
  data() {
    return {
      categoryList: [],
      productList: [],
      randomList: []
    };
  },
  methods: {
    async getCategories() {
      let url = 'api/categories'
      try {
        let response = await fetch(url);
        this.categoryList = await response.json();
        this.totalCategories = this.categoryList.length;
      } catch (error) {
        console.log("Error: ", error)
      }
    },
    created() {
      this.getCategories();
      this.getProducts();

    },
    async getProducts() {
      let url = '/api/products'
      try {

        let response = await fetch(url);
        this.productList = await response.json();
        this.productList=this.productList.sort(() => Math.random() - 0.5)
        this.totalProducts = this.productList.length;
      } catch (error) {
        console.log("Error: ", error)

      }
    },

  }
}

// var prevScrollpos = window.pageYOffset;
// window.onscroll = function() {
// var currentScrollPos = window.pageYOffset;
//   if (prevScrollpos > currentScrollPos) {
//     document.getElementById("test").style.top = "25px";
//   } else {
//     document.getElementById("test").style.top = "-50px";
//   }
//   prevScrollpos = currentScrollPos;
// }

</script>

<template>

  <nav id="test">
    <ul>
      <li v-for="category in categoryList" :key="category.id">
        <router-link :to="{ name: 'ProductsInCategory', params: { id: category.id, name: category.name } }">{{
            category.name
        }} </router-link>
      </li>
    </ul>
  </nav>



  <div class="card" v-for="(product,index) in productList.slice(0,8)" :key="product.id">
    <router-link :to="{ name: 'ProductDetail', params: { productid: product.id } }">
      <div class="imageBlock"><img class="imageCard" :src="product.imageName"></div>
      <p class="title">{{ product.name }}</p>
      <p class="price">€{{ product.price }}</p>
      <!-- <p class="summary">{{product.summary}}</p> -->
    </router-link>
    
  </div>



</template>


<style scoped>
/* #ctgMenu {
  position: fixed;
  display: block;
  margin-top: -210px;
  margin-left: 0;
  text-align: center;
  box-shadow: 0px 3px 5px #000;
  background-color: white;
  /*display: inline-block;*/
  /*overflow: hidden;*/
  /* position: fixed;
  /* width: 75%; */
/*}*/

#test {
  background-color: #333;
  position: fixed;
  top: 25px;
  margin-left: 0;
  padding: 0;
  width: 75%;
  text-align: center;
  box-shadow: 0px 3px 5px #000;
  display: block;
  transition: top 1s;
}


#ctgMenu li {
  display: inline;
  padding-left: 0;
  padding-right: 0;
  text-align: center;
  /* border: 1px solid black; */
}

#ctgMenu a {
  text-decoration: none;
  color: white;
  padding: 10px 20px;
  margin: 0;
  display: inline-block;
}

#ctgMenu li a:hover {
  cursor: pointer;
  color: black;
  background-color: lightgrey;
}

#test {
  background-color: #333;
  position: fixed;
  top: 25px;
  margin-left: 0;
  padding: 0;
  width: 75%;
  text-align: center;
  box-shadow: 0px 3px 5px #000;
  display: block;
  transition: top 1s;

}

#test a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 10px;
  text-decoration: none;
  font-size: 17px;
}

#test li a:hover {
  cursor: pointer;
  color: black;
  background-color: lightgrey;
}

#test li {
  float:left;
  display: inline;
  padding-left: 0;
  padding-right: 0;
  text-align: center;
  /* border: 1px solid black; */
}

#test a {
  text-decoration: none;
  color: white;
  padding: 10px 20px;
  margin: 0;
  display: inline-block;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  width: 290px;
  height: 435px;
  margin-top: 6%;
  text-align: center;
  float:left;
  margin-left: 2.8rem;

}

.card .title {
  font-weight: bold;
}


.card:hover {
  opacity: 1;
  cursor: pointer;
}

.price {
  color: grey;
  font-size: 22px;
}

.card .imageBlock {
  width: 285px;
  height: 285px;
}
.card .imageCard {
  max-width: 280px;
  max-height: 280px;
}


.card a {
text-decoration: none;
color: black;
}


</style>