<template>
  <div>
    <nav class="bg-gray-800 text-white p-4 flex space-x-4">
      <router-link to="/users" class="hover:underline">Users</router-link>
      <router-link to="/admins" class="hover:underline">Admins</router-link>
      <router-link to="/communities" class="hover:underline">Communities</router-link>
    </nav>
    <div class="p-6">
      <router-view />
    </div>
  </div>
</template>
