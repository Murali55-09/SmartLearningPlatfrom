import { createRouter, createWebHistory } from "vue-router";
import Users from "../pages/Users.vue";
import Admins from "../pages/Admins.vue";
import Communities from "../pages/Communities.vue";


const routes = [
  { path: "/", redirect: "/users" }, // default redirect
  { path: "/users", component: Users },
  { path: "/admins", component: Admins },
  { path: "/communities", component: Communities },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
