<template>
  <div>
    <div class="row">
      <div class="col-md-6">
        <br>
        <a href="/">Back</a>
        <br>
        <h1>Add book</h1>
        <br>
        <div class="row">
          <p class="col-md-4"><b>Title</b></p>
          <input type="text" v-model="book.title" class="col-md-8 form form-control" />
        </div>
        <div class="row">
          <p class="col-md-4"><b>Author</b></p>
          <input type="text" v-model="book.author" class="col-md-8 form form-control" />
        </div>
        <div class="row">
          <p class="col-md-4"><b>ISBN</b></p>
          <input type="text" v-model="book.isbn" class="col-md-8 form form-control" />
        </div>
        <div class="row">
          <button type="button" v-on:click="addBook" class="col-md-4 offset-md-8 btn btn-primary">Add</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios"

export default {
  name: 'book-add',
  components: {

  },
  data: function() {
    return {
      book: {
        title: "",
        author: "",
        isbn: ""
      }
    }
  },
  methods: {
    addBook: function() {
      axios.post("http://localhost:8080/api/inventory/books", this.book)
        .then(response => {
          console.log(response)
          alert("Successfully added")
          this.book.title = ""
          this.book.author = ""
          this.book.isbn = ""
        })
        .catch(e => {
          console.log(e)
        })
      }
  }
}
</script>
