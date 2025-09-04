<template>
  <form @submit.prevent="addUser">
    <input v-model="newUser.name" placeholder="Name" />
    <input v-model="newUser.email" placeholder="Email" />
    <button type="submit">Add User</button>
  </form>
</template>

<script>
import userService from "@/services/userService";

export default {
  data() {
    return {
      newUser: { name: "", email: "" },
    };
  },
  methods: {
    async addUser() {
      try {
        const response = await userService.createUser(this.newUser);
        console.log("User added:", response.data);
        // Optionally clear the form
        this.newUser = { name: "", email: "" };
      } catch (error) {
        console.error("Error adding user:", error);
      }
    },
  },
};
</script>
