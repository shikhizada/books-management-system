import Vue from 'vue'
import App from './App.vue'
import router from './router'

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

import { library } from '@fortawesome/fontawesome-svg-core'
import {
  faPencilAlt, faTrashAlt,
  faAngleLeft, faAngleRight,
  faAngleDoubleLeft, faAngleDoubleRight
} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(
  faPencilAlt, faTrashAlt,
  faAngleLeft, faAngleRight,
  faAngleDoubleLeft, faAngleDoubleRight
)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

new Vue({
  router,
  render: function (h) { return h(App) }
}).$mount('#app')
