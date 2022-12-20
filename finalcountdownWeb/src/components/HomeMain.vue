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
      <img class="imageCard" :src="product.imageName">
      <p class="title">{{ product.name }}</p>
      <p class="price">€{{ product.price }}</p>
      <!-- <p class="summary">{{product.summary}}</p> -->
    </router-link>
    
  </div>



</template>


<style scoped>
#ctgMenu {
  position: fixed;
  display: block;
  margin-top: -210px;
  margin-left: 0;
  text-align: center;
  box-shadow: 0px 3px 5px #000;
  background-color: white;
  /*display: inline-block;*/
  /*overflow: hidden;*/
  position: fixed;
  width: 75%;
}

#ctgMenu li {
  display: inline;
  padding-left: 5%;
  padding-right: 5%;
  text-align: center;
  /* border: 1px solid black; */
}

#ctgMenu a {
  text-decoration: none;
  color: black;
  padding: 10px 20px;
  margin: 0;
  display: inline-block;
}

#ctgMenu li a:hover {
  cursor: pointer;
  color: lightcyan;
  background-color: black;
}

#test {
  background-color: #333;
  position: fixed;
  top: 25px;
  margin-left: 0px;
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
  padding: 15px;
  text-decoration: none;
  font-size: 17px;
}

#test li a:hover {
  cursor: pointer;
  color: lightcyan;
  background-color: black;
}

#test li {
  float:left;
  display: inline;
  padding-left: 5%;
  padding-right: 5%;
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
  max-width: 400px;
  margin-top: 8%;
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

.card .imageCard {
  width: 300px;
  height: 300px;
}


.card a {
text-decoration: none;
color: black;
}


</style>