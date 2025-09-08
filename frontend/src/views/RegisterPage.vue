<template>
  <div class="min-h-screen flex items-center justify-center bg-gradient-to-r from-purple-400 via-pink-400 to-red-400">
    <div class="max-w-md w-full bg-white shadow-lg rounded-lg p-8">
      <div class="text-center mb-6">
        <img src="@/assets/register_logo.png" alt="Register" class="mx-auto w-24 h-24 rounded-full"/>
        <h1 class="text-2xl font-bold mt-4">Create Account</h1>
      </div>
      <form @submit.prevent="register">
        <div class="mb-4">
          <label class="block text-gray-700">Name</label>
          <input type="text" v-model="name" class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-purple-500 focus:outline-none"/>
        </div>
        <div class="mb-4">
          <label class="block text-gray-700">Email</label>
          <input type="email" v-model="email" class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-purple-500 focus:outline-none"/>
        </div>
        <div class="mb-4">
          <label class="block text-gray-700">Password</label>
          <input type="password" v-model="password" class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-purple-500 focus:outline-none"/>
        </div>
        <button type="submit" class="w-full bg-purple-600 hover:bg-purple-700 text-white font-bold py-2 rounded-lg transition duration-300">
          Register
        </button>
      </form>
      <p class="text-sm text-gray-500 mt-4 text-center">
        Already have an account? 
        <router-link to="/login" class="text-purple-600 hover:underline">Login</router-link>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "RegisterPage", 
  data() {
    return {
      name: "",
      email: "",
      password: ""
    };
  },
  methods: {
    register() {
      // Your registration logic
    }
  }
};
</script>
