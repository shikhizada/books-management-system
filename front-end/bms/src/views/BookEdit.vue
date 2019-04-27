<template>
  <div>
    <div class="row">
      <div class="col-md-5">
        <br>
        <h1>Edit book</h1>
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
          <button type="button" v-on:click="updateBook" class="col-md-4 offset-md-8 btn btn-primary">Update</button>
        </div>
      </div>

      <div class="col-md-2">
      </div>

      <div class="col-md-5">
        <br>
        <h1>Comments</h1>
        <br>
        <div class="row">
          <p class="col-md-4"><b>Comment</b></p>
          <textarea rows="4" v-model="newComment.content" class="col-md-8 form form-control"></textarea>
        </div>
        <div class="row">
          <button type="button" v-on:click="addComment" class="col-md-4 offset-md-8 btn btn-primary">Add comment</button>
        </div>
        <div v-for="comment in book.comments">
          <div class="row">
            <p class="col-md-4">Date</p>
            <p class="col-md-8">{{comment.postDate}}</p>
          </div>
          <div class="row">
            <p class="col-md-4">Comment</p>
            <p class="col-md-8">{{comment.content}}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'book-edit',
  components: {

  },
  data: function() {
    return {
      book: {},
      newComment: {
        content: "",
        postDate: this.getDate()
      }
    }
  },
  methods: {
    updateBook: function() {
      axios.put("http://localhost:8080/api/inventory/books/" + this.book._id, this.book)
        .then(response => {
          console.log(response);
          alert("Successfully updated")
          this.$router.push('/')
        })
        .catch(e => {
          console.log(e);
        });
    },
    addComment: function() {
      axios.post("http://localhost:8080/api/inventory/books/" + this.book._id + "/comments", this.newComment)
        .then(response => {
          this.$router.go("/books/" + this.$route.params.id);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getDate: function() {
      var date = new Date();
      var yyyy = date.getFullYear();
      var mm = String(date.getMonth() + 1).padStart(2, '0');
      var dd = String(date.getDate()).padStart(2, '0');
      date = yyyy + '-' + mm + '-' + dd;
      return date;
    }
  },
  mounted: function() {
    axios.get("http://localhost:8080/api/inventory/books/" + this.$route.params.id)
      .then(response => {
        console.log(response);
        this.book = response.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
}
</script>
