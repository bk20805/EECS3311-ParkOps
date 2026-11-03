# ParkOps: where to begin

## Project route amendment - 18 September 2026

Choose ONE individual project route: the supplied ParkOps scenario, or an instructor-approved
client project with an equivalent written mapping of every required behaviour and acceptance case.
No client is required and a client route earns no extra marks. ParkOps work remains valid.
For ParkOps, use this fixture and the technical briefs directly. For the client route, the approved
mapping replaces domain-specific names, fixtures and business rules while preserving the common
Java 21, JUnit Jupiter 6.0.3, supervised-agent, testing, timing and approval requirements.

Read [PROJECT_AMENDMENT_2026-09-18.md](PROJECT_AMENDMENT_2026-09-18.md) before implementation.
It contains the full published route amendment, approval process and the D1 booking clarification.
Project deadlines are D1: 13 October 2026, 23:59 (10%); D2: 6 November 2026, 23:59 (10%);
D3: 30 November 2026, 23:59 (15%), all Toronto time. Total: 35%.

## Supplied and student work

Supplied: Java 21 build scripts; JUnit 6.0.3 setup; strict small JSON codec; immutable
message type; ModelProvider interface; ReplayProvider; non-streaming Ollama HTTP adapter;
synthetic A17/B12/C03/D09 data; public infrastructure checks; a deliberately incomplete
D1 testing boundary. None of these files is a completed ParkOps agent.

Students implement: protected domain objects; validation; eligibility and proposal storage;
UML diagrams; the pending-proposal path; tool-request validation and dispatch; observation
history; a bounded loop; operator approval/rejection/execution; duplicate protection;
controllable periodic ticks; policy evolution; refactoring; meaningful tests and contracts.

The record types ChatMessage and ProposalView are immutable transport containers supplied
for convenience. A record alone does not enforce the domain rules. Choose and explain your
own internal design. Adapt public method names with a documented equivalent test mapping
if your architecture differs; do not remove a required acceptance case.

## D1 booking clarification

You may create or initialise bookings in StudentApplication or your own domain classes.
The instruction about never moving a booking refers specifically to propose(targetId).
That method creates a PENDING proposal; it must preserve the entire booking and occupancy
state, including location and version. For the baseline B12 proposal, B1 stays at A17/version 0.
Replacing B1 with a newly created booking at B12 would also be an impermissible committed move.
Actual movement belongs to D2's separate human approval/execution path with current-state checks.
Rejected proposals also leave the original state unchanged. Client projects apply the same rule
to their mapped entities and resource availability. Add tests that demonstrate these boundaries.

## Commands

    bash run.sh compile
    bash run.sh run fixture
    bash run.sh smoke
    bash run.sh run scripted
    bash run.sh check
    bash setup-junit.sh
    bash run.sh test

PowerShell equivalents replace bash run.sh with ./run.ps1 and bash setup-junit.sh with
./setup-junit.ps1. smoke tests infrastructure and an in-process fake HTTP endpoint.
It does not test a real model or a completed D1/D2/D3 implementation.

Initially compile, fixture and smoke should succeed. scripted, check and test should
report the unfinished D1 methods. Do not present those failures as completed student work.
When D1 works, scripted creates a pending proposal while the booking stays A17/version 0.
It must never silently approve or execute. Do not print a successful proposal without
creating the state required by the brief.

For D2, implement StudentApplication.run and use run agent-scripted. Preserve the D1
command as a regression demonstration. Connect the scripted mode to the completed
D2 workflow (or document the agent-scripted alias) for the required D2 assessment command.

## Live model route

Use only the course-supported endpoint and model. OLLAMA_CHAT_URL must be the complete
HTTP(S) URL ending /api/chat; OLLAMA_MODEL is its installed model identifier. Set these
locally and invoke run live after implementing the bounded application loop. No value is
assumed here. The adapter transmits only the conversation supplied to it; use synthetic
course data. Do not put passwords/API keys in URLs, source, transcripts or ZIP files.

The adapter returns untrusted text. Students must enforce exactly the required three
string fields, allowed tools, goal booking, read/list ordering, attempt limit and approval
boundary in Java. JSON syntax validity is not permission to execute a tool. Record actual
assistant responses and Java tool observations; replay cannot substitute for a live transcript.

If supported model access has not been supplied, record LIVE_RUN_PENDING_COURSE_ACCESS.
No live model has been run as part of this starter release. No paid account is required.
The adapter uses a request timeout and no redirects, and rejects malformed envelopes.
It is classroom infrastructure, not a production hardened client.

## Milestone checklist

The names and fixtures below describe ParkOps. For the client route, use the instructor-approved
equivalents and preserve the same required behaviours, limits and acceptance-test coverage.

- D1: the overview's valid identifier/duration rules; diagram consistency; B12 pending
  proposal with versions 0/1; D09/unknown rejection; unchanged booking state and safe snapshots.
- D2: read/list/propose/finish protocol; every model invocation counted within 1–6;
  controlled malformed/unknown/wrong-goal rejection; separate operator actions; revalidation
  of booking and policy versions/eligibility; exactly one simulated commit/notification;
  ticks 0,59,60 with no waiting and backwards-clock rejection. Failed work requires an
  operator retry or a relevant version change. Preserve all D1 regressions.
- D3: policy 2 requires accessible targets when the booking requires it, leaving C03
  as B1's only eligible target; old-policy proposals stale; fresh proposals may commit;
  refactor a real D2 problem; -Xlint:all and dependency review; local contracts with stated
  frame conditions, class and loop invariants. Record actual OpenJML output or the explicit
  unsupported-tool status and manual argument allowed by the brief.

## Evidence and submission

Use the supplied PDF briefs for dates, weights, page limits, rubrics, accepted tools and
submission naming. This starter adds no grading rule. DESIGN.pdf is a student-authored
deliverable; a fake blank PDF is not supplied. Complete TEST_PLAN.md and CHANGELOG.md.
Capture actual outputs in results/d1.txt, results/d2.txt and results/d3.txt when each exists.
Do not pre-fill results or delete failing cases. Exclude downloaded libraries and build files.

Reference: https://docs.ollama.com/api/chat
