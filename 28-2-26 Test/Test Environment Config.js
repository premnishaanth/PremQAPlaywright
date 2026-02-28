let env = 'dev';

const BASE_URLS = {
    dev: 'https://dev-api.yourcompany.com/v1',
    staging: 'https://staging-api.yourcompany.com/v1',
    qa: 'https://qa-api.yourcompany.com/v1',
    production: 'https://api.yourcompany.com/v1'
};

const API_KEY_PATTERNS = {
    dev: 'dev_xxxxxxxxxxxxxxxxxxxxxx',
    staging: 'stg_xxxxxxxxxxxxxxxxxxxxxx',
    qa: 'qa_xxxxxxxxxxxxxxxxxxxxxx',
    production: 'prod_xxxxxxxxxxxxxxxxxxxxxx'
};

const TIMEOUTS = {
    dev: 30000,      // 30s - Fast feedback
    staging: 45000,  // 45s - Service dependencies
    qa: 60000,       // 60s - Load testing
    production: 120000 // 120s - Production caution
};

const DESCRIPTIONS = {
    dev: 'Development - Feature branches, no data retention',
    staging: 'Staging - Integration testing, mock payments',
    qa: 'QA - Full E2E testing, production-like data',
    production: 'Production - Live traffic, zero tolerance'
};

let baseUrl, apiKeyPattern, timeout, description;

switch (env) {
    case 'dev':
        baseUrl = BASE_URLS.dev;
        apiKeyPattern = API_KEY_PATTERNS.dev;
        timeout = TIMEOUTS.dev;
        description = DESCRIPTIONS.dev;
        break;

    case 'staging':
        baseUrl = BASE_URLS.staging;
        apiKeyPattern = API_KEY_PATTERNS.staging;
        timeout = TIMEOUTS.staging;
        description = DESCRIPTIONS.staging;
        break;

    case 'qa':
        baseUrl = BASE_URLS.qa;
        apiKeyPattern = API_KEY_PATTERNS.qa;
        timeout = TIMEOUTS.qa;
        description = DESCRIPTIONS.qa;
        break;

    case 'prod':
        baseUrl = BASE_URLS.production;
        apiKeyPattern = API_KEY_PATTERNS.production;
        timeout = TIMEOUTS.production;
        description = DESCRIPTIONS.production;
        break;

    default:
        console.log("Invalid Environment");
}