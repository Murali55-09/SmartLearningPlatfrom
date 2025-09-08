<template>
  <div>
    <h2>Admin Dashboard</h2>
    <p>Welcome, Admin!</p>
    <button @click="logout">Logout</button>
  </div>
</template>

<script>
export default {
  name: "AdminDashboard",
  methods: {
    logout() {
      localStorage.removeItem("userRole");
      this.$router.push("/login");
    },
  },
};
</script>
