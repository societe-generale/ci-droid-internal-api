# Changelog - see https://keepachangelog.com for conventions

## [Unreleased]

### Added

### Changed
- adding @JsonIgnore on getDescriptionForUI so that the field isn't exposed when part of Swagger doc

### Deprecated

### Removed

### Fixed

## [1.0.4] - 2018-09-20

### Fixed
- pullRequestName field should actually be named pullRequestTitle

## [1.0.3] - 2018-09-19

### Added
- added a pullRequestName field on PullRequestGitHubInteraction

## [1.0.2] - 2018-08-02

### Fixed
- re-adding javax.el dependency in main code, as it's required by application using internal-api - this way they don't need to import it themselves. 
- setting javax.el to 3.0.0 to avoid confusion 

## [1.0.1] - 2018-07-11

### Added
- adding a new constructor signature on IssueProvidingContentException, to pass the original exception
- we can now make Maven releases through Travis 

### Removed
- getType method in ActionToReplicate interface, as it's not required (we'll use the fully qualified class name now)

## [1.0.0] - 2018-06-19

first version !

