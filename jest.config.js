module.exports = {
    coverageProvider: "v8",
    rootDir: "target/node_spec",
    testEnvironment: "jsdom",
    testMatch: [
        "**/*.*_spec.js",
        "**/*_spec.js",
    ],
};