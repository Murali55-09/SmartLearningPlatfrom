<template>
  <header class="bg-white shadow-md">
    <div class="container mx-auto flex items-center justify-between py-4 px-6">
      <div class="flex items-center space-x-4">
        <img src="https://images.unsplash.com/photo-1601597111597-0a51f67a16a6?auto=format&fit=crop&w=50&q=80" alt="Logo" class="w-10 h-10 rounded-full"/>
        <span class="font-bold text-xl">SmartLearn</span>
      </div>
      <nav class="hidden md:flex space-x-6">
        <router-link to="/">Home</router-link>
        <router-link to="/categories">Categories</router-link>
        <router-link to="/about">About</router-link>
        <router-link to="/contact">Contact</router-link>
        <router-link to="/login">Login</router-link>
        <router-link to="/register">Signup</router-link>
      </nav>
      <div class="md:hidden">
        <button @click="toggleMenu" class="focus:outline-none">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"/>
          </svg>
        </button>
      </div>
    </div>
    <div v-if="showMenu" class="md:hidden bg-white shadow-md px-6 py-4 flex flex-col space-y-2">
      <router-link to="/">Home</router-link>
      <router-link to="/categories">Categories</router-link>
      <router-link to="/about">About</router-link>
      <router-link to="/contact">Contact</router-link>
      <router-link to="/login">Login</router-link>
      <router-link to="/register">Signup</router-link>
    </div>
  </header>
</template>

<script>
export default {
  name: "AppHeader",
  data() {
    return {
      showMenu: false
    };
  },
  methods: {
    toggleMenu() {
      this.showMenu = !this.showMenu;
    }
  }
};
</script>

<style scoped>
.container { max-width: 1200px; }
</style>
