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
          <th scope="row">{{currentPage * limit + index + 1}}</th>
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

    <ul v-if="totalPages > 0" class="pagination justify-content-center">
      <li v-bind:class="{'page-item':true, 'disabled':(currentPage === 0)}">
        <a v-on:click="getBooks(0)" class="page-link" href="#"><font-awesome-icon icon="angle-double-left" /></a>
      </li>
      <li v-bind:class="{'page-item':true, 'disabled':(currentPage === 0)}">
        <a v-on:click="getBooks(currentPage - 1)" class="page-link" href="#"><font-awesome-icon icon="angle-left" /></a>
      </li>
      <li v-for="page in totalPages" v-bind:class="{'page-item':true, 'active':(currentPage === page - 1)}">
        <a v-on:click="getBooks(page - 1)" class="page-link" href="#">{{page}}</a>
      </li>
      <li v-bind:class="{'page-item':true, 'disabled':(currentPage === totalPages - 1)}">
        <a v-on:click="getBooks(currentPage + 1)" class="page-link" href="#"><font-awesome-icon icon="angle-right" /></a>
      </li>
      <li v-bind:class="{'page-item':true, 'disabled':(currentPage === totalPages - 1)}">
        <a v-on:click="getBooks(totalPages - 1)" class="page-link" href="#"><font-awesome-icon icon="angle-double-right" /></a>
      </li>
    </ul>
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
      books: [],
      totalPages: 0,
      currentPage: 0,
      limit: 5
    }
  },
  methods: {
    getBooks: function(page) {
      axios.get("http://localhost:8080/api/inventory/books?page=" + page + "&limit=" + this.limit)
        .then(response => {
          console.log(response);
          this.books = response.data.elements;
          this.totalPages = response.data.totalPages
          this.currentPage = response.data.page
        })
        .catch(e => {
          console.log(e);
        });
    },
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
    this.getBooks(0);
  }
}
</script>
