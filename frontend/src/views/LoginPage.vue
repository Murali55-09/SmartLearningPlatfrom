<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="max-w-md w-full bg-white shadow-lg rounded-lg p-8">
      <div class="text-center mb-6">
        <img src="https://images.unsplash.com/photo-1601597111597-0a51f67a16a6?auto=format&fit=crop&w=100&q=80" 
             alt="Login" class="mx-auto w-24 h-24 rounded-full"/>
        <h1 class="text-2xl font-bold mt-4">Welcome Back</h1>
        <p class="text-gray-500">Please login to your account</p>
      </div>
      <form @submit.prevent="login">
        <div class="mb-4">
          <label class="block text-gray-700">Email</label>
          <input type="email" v-model="email" class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none"/>
        </div>
        <div class="mb-4">
          <label class="block text-gray-700">Password</label>
          <input type="password" v-model="password" class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none"/>
        </div>
        <button type="submit" class="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 rounded-lg transition duration-300">
          Login
        </button>
      </form>
      <p class="text-sm text-gray-500 mt-4 text-center">
        Don't have an account? 
        <router-link to="/register" class="text-blue-600 hover:underline">Register</router-link>
      </p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginPage",
  data() {
    return {
      email: "",
      password: ""
    };
  },
  methods: {
    async login() {
      if (!this.email || !this.password) {
        alert("Please enter email and password");
        return;
      }

      try {
        const response = await axios.post("http://localhost:8080/api/auth/user", {
          email: this.email,
          password: this.password
        });

        const role = response.data.role; // Get role from JSON

        if (role === "ADMIN") {
          this.$router.push({ name: "AdminDashboard" });
        } else if (role === "STUDENT") {
          this.$router.push({ name: "StudentDashboard" });
        } else {
          alert("Invalid credentials or role");
        }
      } catch (error) {
        console.error(error);
        alert("Login failed. Check your email and password.");
      }
    }
  }
};
</script>
