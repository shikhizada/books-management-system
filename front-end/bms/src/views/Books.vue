<template>
  <div>
    <br>
    <h1>Books</h1>
    <br>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Title</th>
          <th scope="col">Author</th>
          <th scope="col">ISBN-13</th>
          <th scope="col">Comments</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(book, index) in books">
          <th scope="row">{{index + 1}}</th>
          <td>{{book.title}}</td>
          <td>{{book.author}}</td>
          <td>{{book.isbn}}</td>
          <td>{{book.comments.length}}</td>
          <td>
            <a :href="'/books/'+book._id" class="mr-3"><font-awesome-icon icon="pencil-alt" /></a>
            <a href="#" v-on:click="deleteBook(book._id)"><font-awesome-icon icon="trash-alt" /></a>
          </td>
        </tr>
      </tbody>
    </table>
    <a href="/books/add" class="col-md-2 offset-md-10 btn btn-primary">Add book</a>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'books',
  components: {

  },
  data: function() {
    return {
      books: []
    }
  },
  methods: {
    deleteBook: function(id) {
      axios.delete("http://localhost:8080/api/inventory/books/" + id)
        .then(response => {
          console.log(response);
          alert("Book with the name " + response.data.title + " was removed");
          this.$router.go();
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted: function() {
    axios.get("http://localhost:8080/api/inventory/books")
      .then(response => {
        console.log(response);
        this.books = response.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
}
</script>
