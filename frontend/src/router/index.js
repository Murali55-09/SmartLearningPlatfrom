import { createRouter, createWebHistory } from "vue-router";

// Import all views (make sure these files exist in src/views/)
import HomePage from "../views/HomePage.vue";
import LoginPage from "../views/LoginPage.vue";
import RegisterPage from "../views/RegisterPage.vue";
import StudentDashboard from "../views/StudentDashboard.vue";
import AdminDashboard from "../views/AdminDashboard.vue"; // 🔥 added this

const routes = [
  { path: "/", name: "Home", component: HomePage },
  { path: "/login", name: "Login", component: LoginPage },
  { path: "/register", name: "Register", component: RegisterPage },
  { path: "/student-dashboard", name: "StudentDashboard", component: StudentDashboard },
  { path: "/admin-dashboard", name: "AdminDashboard", component: AdminDashboard } // 🔥 added this
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
