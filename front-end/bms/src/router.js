import Vue from 'vue'
import Router from 'vue-router'
import Books from './views/Books.vue'
import BookAdd from './views/BookAdd.vue'
import BookEdit from './views/BookEdit.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'books',
      component: Books
    },
    {
      path: '/books/add',
      name: 'book-add',
      component: BookAdd
    },
    {
      path: '/books/:id',
      name: 'book-edit',
      component: BookEdit
    }
  ]
})
